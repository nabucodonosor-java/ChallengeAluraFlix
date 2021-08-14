import { Route, Switch } from 'react-router-dom';
import Navbar from './Navbar';
import './styles.css';
import Users from './User';

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
            <Users />
          </Route>
        </Switch>
      </div>
    </div>
  );
}

export default Admin;
