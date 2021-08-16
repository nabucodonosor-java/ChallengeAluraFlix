import PrivateRoute from 'components/PrivateRoute';
import { Switch } from 'react-router-dom';
import Navbar from './Navbar';
import './styles.css';
import Users from './User';

const Admin = () => {
  return ( 
    <div className="admin-container">
      <Navbar />
      <div className="admin-content">
        <Switch>
          <PrivateRoute path="/admin/videos">
            <h1>CRUD Vídeos</h1>
          </PrivateRoute>
          <PrivateRoute path="/admin/categorias">
            <h1>CRUD Categorias</h1>
          </PrivateRoute>
          <PrivateRoute path="/admin/usuarios">
            <Users />
          </PrivateRoute>
        </Switch>
      </div>
    </div>
  );
}

export default Admin;
