import MainImage from 'assets/images/main-image.svg';
import ButtonIcon from 'components/ButtonIcon';
import Navbar from 'components/Navbar';
import './styles.css';

const Home = () => {

    return (
        <>
        <Navbar />
        <div className="home-container">
            <div className="home-card">
                <div className="home-content-container">
                    <h1>React App Alura Flix</h1>
                    <p>Interface gráfica desenvolvida em React + TS para consumir API desenvolvida durante o ChallengeAluraBackend</p>
                    <ButtonIcon />
                </div>
                <div className="home-image-container">
                    <img src={MainImage} alt="imagem"/>
                </div>
            </div>
        </div>
        </>
    );
}

export default Home;