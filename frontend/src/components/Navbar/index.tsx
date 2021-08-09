import './styles.scss';
import 'bootstrap/js/src/collapse.js';

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-md navbar-dark bg-primary main-nav">
      <div className="container-fluid">
        <a href="link" className="nav-logo-text">
          <h4>AluraFlix</h4>
        </a>

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
              <a href="link">Home</a>
            </li>
            <li>
              <a href="link">Vídeos</a>
            </li>
            <li>
              <a href="link">Cadastro</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
