import ReactPlayer from 'react-player';
import { Video } from 'types/video';
import './styles.css';

type Props = { 
    video: Video;
}

const VideoCard = ({ video } : Props) => {
    return (
        <div className="base-card video-card">
            <div className="card-top-container">
                <ReactPlayer url={video.url} height="160px" width="150px" />
            </div>
            <div className="card-bottom-container">
                <h6>{video.titulo}</h6>
            </div>
            <div className="card-footer-container">
                <span>Categoria:</span><p>{video.nomeCategoria}</p>
            </div>
        </div> 
    );
}

export default VideoCard;