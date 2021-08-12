import { NavLink } from 'react-router-dom';
import './styles.css';

const Navbar = () => {
  return ( 
    <nav className="admin-nav-container">
      <ul>

        <li> 
          <NavLink to="/admin/videos" className="admin-nav-item">
            <p>Vídeos</p>
          </NavLink>
        </li>

        <li>
        <NavLink to="/admin/categorias" className="admin-nav-item">
          <p>Categorias</p>
        </NavLink>
        </li>

        <li>
        <NavLink to="/admin/usuarios" className="admin-nav-item">
          <p>Usuários</p>
        </NavLink>
        </li>

      </ul>
    </nav>
  );
}

export default Navbar;
