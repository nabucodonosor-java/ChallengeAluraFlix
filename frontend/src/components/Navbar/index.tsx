import { NavLink, Link } from 'react-router-dom';
import { getTokenData, isAuthenticated } from 'util/auth';
import React, { useContext, useEffect } from 'react';
import { removeAuthData } from 'util/storage';
import history from 'util/history';

import './styles.css';
import 'bootstrap/js/src/collapse.js';
import { AuthContext } from 'AuthContext';

const Navbar = () => {

  const { authContextData, setAuthContextData } = useContext(AuthContext);

  useEffect(() => {
    if (isAuthenticated()) {
      setAuthContextData({
        authenticated: true,
        tokenData: getTokenData(),
      });
    } else {
      setAuthContextData({
        authenticated: false,
      });
    }
  }, [setAuthContextData]);

  const handleLogoutClick = (event: React.MouseEvent<HTMLAnchorElement>) => {
    event.preventDefault();
    removeAuthData();
    setAuthContextData({
      authenticated: false,
    });
    history.replace('/');
  };

  return (
    <nav className="navbar navbar-expand-md navbar-dark bg-primary main-nav">
      <div className="container-fluid">
        <Link to="/" className="nav-logo-text">
          <h4>AluraFlix</h4>
        </Link>

        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#aluraflix-navbar"
          aria-controls="aluraflix-navbar"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="aluraflix-navbar">
          <ul className="navbar-nav offset-md-2 navbar-main-menu">
            <li>
              <NavLink to="/" exact activeClassName="active">
                Home
              </NavLink>
            </li>
            <li>
              <NavLink to="/videos" activeClassName="active">
                Vídeos
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin" activeClassName="active">
                Add Vídeo
              </NavLink>
            </li>
          </ul>
        </div>
        <div className="navbar-login-logout">
          {authContextData.authenticated ? (
            <div className="navbar-login-content">
              <Link className="nav-link-login-logout" to="#logout" onClick={handleLogoutClick}>
                LOGOUT
              </Link>
              <span className="nav-username">{authContextData.tokenData?.user_name}</span>
            </div>
          ) : (
            <Link className="nav-link-login-logout" to="/admin/auth/login">LOGIN</Link>
          )}
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
