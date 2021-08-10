import './styles.css';
import 'bootstrap/js/src/collapse.js';
import { NavLink, Link } from 'react-router-dom';

const Navbar = () => {
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
              <NavLink to="/" exact activeClassName="active">Home</NavLink>
            </li>
            <li>
              <NavLink to="/videos" activeClassName="active">Vídeos</NavLink>
            </li>
            <li>
              <NavLink to="/admin" activeClassName="active">Add Vídeo</NavLink>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
