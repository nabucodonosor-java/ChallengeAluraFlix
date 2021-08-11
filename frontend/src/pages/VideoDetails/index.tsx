import { ReactComponent as ArrowIcon } from 'assets/images/arrow.svg';
import ReactPlayer from 'react-player';

import './styles.css';

const VideoDetails = () => {
  return (
    <div className="video-details-container">
      <div className="video-details-card base-card">
        <div className="goback-container">
          <ArrowIcon />
          <h2>VOLTAR</h2>
        </div>
        <div className="row">
          <div className="col-xl-6">
            <div className="video-container">
              <ReactPlayer
                controls
                url="https://www.youtube.com/watch?v=QLuYGxJzNlE&t=242s"
                width="100%"
              />
            </div>
            <div className="video-description">
              <h1>A Guerra Franco-Prussiana</h1>
              <p>A Guerra Franco-Prussiana e a Unificação da Alemanha</p>
              <p>
                <strong>Categoria:</strong> Animes
              </p>
            </div>
          </div>
          <div className="col-xl-6">
            <div className="videos-comments base-card">
              <h1>Comentários</h1>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default VideoDetails;
