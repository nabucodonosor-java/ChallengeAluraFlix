import './styles.css';

const Navbar = () => {
  return ( 
    <nav className="admin-nav-container">
      <ul>

        <li> 
          <a href="#videos" className="admin-nav-item active">
            <p>Vídeos</p>
          </a>
        </li>

        <li>
        <a href="#categorias" className="admin-nav-item">
          <p>Categorias</p>
        </a>
        </li>

        <li>
        <a href="#usuarios" className="admin-nav-item">
          <p>Usuários</p>
        </a>
        </li>

      </ul>
    </nav>
  );
}

export default Navbar;
