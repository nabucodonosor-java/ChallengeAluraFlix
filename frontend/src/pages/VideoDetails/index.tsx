import { ReactComponent as ArrowIcon } from 'assets/images/arrow.svg';
import UserComment from 'components/Comment';
import ReactPlayer from 'react-player';
import { Link } from 'react-router-dom';
import { Comment } from 'types/comment';

import './styles.css';

const VideoDetails = () => {

  const comment: Comment = {
    "id": 1,
    "userName": "Franco Brasil",
    "text": "A Guerra Franco-Prussiana e a Unificação da Alemanha"
};

  return (
    <div className="video-details-container">
      <div className="video-details-card base-card">
        <div>
          <Link to="/videos" className="goback-container">
          <ArrowIcon />
          <h2>VOLTAR</h2>
          </Link>
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
            <div className="videos-comments">
              <h1>Comentários</h1>
              <UserComment comment={comment} />
              <UserComment comment={comment} />
              <UserComment comment={comment} />
              <UserComment comment={comment} />
              <UserComment comment={comment} />
              <UserComment comment={comment} />
              <UserComment comment={comment} />
              <UserComment comment={comment} />            
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default VideoDetails;
