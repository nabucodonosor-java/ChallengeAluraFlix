
import ButtonIconHome from 'components/ButtonIconHome';
import './styles.css';

const Home = () => {
  return (
    <div className="home-container">
      <div className="base-card home-card">
        <div className="home-content-container">
          <div>
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
  );
}

export default Home;
