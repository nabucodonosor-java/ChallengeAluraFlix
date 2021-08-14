import AuthImg from 'assets/images/auth-image.png';
import { Route, Switch } from 'react-router-dom';
import Login from './Login';

import './styles.css';

const Auth = () => {
  return ( 
    <div className="auth-container">
      <div className="auth-banner-container">
        <h1>Alura Flix</h1>
        <p>Área de autenticação</p>
        <img src={AuthImg} alt="logo"/>
      </div>

      <div className="auth-form-container base-card">
        <Switch>
          <Route path="/admin/auth/login">
            <Login />
          </Route>
          <Route path="/admin/auth/cadastro">
            <h1>Card de Cadastro</h1>
          </Route>
          <Route path="/admin/auth/recuperar">
            <h1>Card de Recuperação de senha</h1>
          </Route>
        </Switch>
      </div>
       
    </div>
  );
}

export default Auth;
