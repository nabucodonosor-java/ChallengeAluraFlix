import MainImage from 'assets/images/main-image.jpg';
import ButtonIcon from 'components/ButtonIcon';
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
              desenvolvida durante o desafio de backend da Alura.
              <strong>#ChallengeAluraBackend</strong>
            </p>
          </div>
          <ButtonIcon />
        </div>
        <div className="home-image-container">
          <img src={MainImage} alt="imagem" />
        </div>
      </div>
    </div>
  );
}

export default Home;
