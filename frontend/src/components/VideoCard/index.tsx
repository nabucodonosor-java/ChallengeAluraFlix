import ReactPlayer from 'react-player';
import './styles.css';

const VideoCard = () => {
    return (
        <div className="base-card video-card">
            <div className="card-top-container">
                <ReactPlayer url="https://www.youtube.com/watch?v=-t_E75pArRM" height="160px" width="150px"/>
            </div>
            <div className="card-bottom-container">
                <h6>API REST com Spring Webflux e MongoDB</h6>
                <p>API REST com Spring Webflux e MongoDB: parte2 - criando um Document e Repository</p>
                <button className="text-center">Comentários</button>
            </div>
        </div> 
    );
}

export default VideoCard;