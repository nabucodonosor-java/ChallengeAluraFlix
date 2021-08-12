import { Route, Switch } from 'react-router-dom';
import Navbar from './Navbar';
import './styles.css';

const Admin = () => {
  return ( 
    <div className="admin-container">
      <Navbar />
      <div className="admin-content">
        <Switch>
          <Route path="/admin/videos">
            <h1>CRUD Vídeos</h1>
          </Route>
          <Route path="/admin/categorias">
            <h1>CRUD Categorias</h1>
          </Route>
          <Route path="/admin/usuarios">
            <h1>CRUD Usuários</h1>
          </Route>
        </Switch>
      </div>
    </div>
  );
}

export default Admin;
