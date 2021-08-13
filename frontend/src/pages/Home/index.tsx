
import axios from 'axios';
import ButtonIconHome from 'components/ButtonIconHome';
import Loader from 'components/Loader';
import { useState, useEffect } from 'react';
import './styles.css';

const Home = () => {

  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    axios({ url: '/' })
        .then(response => response.data)
        .finally(() => setIsLoading(false));
}, []);

  return ( 
   <>
   {isLoading ? <Loader /> : (
    <div className="home-container">
      <div className="base-card home-card">
        <div className="home-content-container">
          <div className="home-content-title">
            <h1>React App Alura Flix</h1>
            <p>
              Interface gráfica desenvolvida em React + TS para consumir API
              desenvolvida durante o desafio de backend da Alura.<br/>
              <strong>#ChallengeAluraBackend</strong>
            </p>
          </div>
          <ButtonIconHome text="CADASTRE-SE JÁ!" />
        </div>
        
      </div>
    </div>
    )}
    </>
  );
}

export default Home;
