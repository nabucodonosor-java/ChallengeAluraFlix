import { ReactComponent as ArrowIcon } from 'assets/images/arrow.svg';
import axios from 'axios';
import UserComment from 'components/Comment';
import { useState, useEffect } from 'react';
import ReactPlayer from 'react-player';
import { Link, useParams } from 'react-router-dom';
import { BASE_URL } from 'util/request';
import { Comment } from 'types/comment';
import { Video } from 'types/video';

import './styles.css';

const VideoDetails = () => {

  const comment: Comment = {
    "id": 1,
    "userName": "Franco Brasil",
    "text": "A Guerra Franco-Prussiana e a Unificação da Alemanha"
};

type UrlParams = {
  videoId: string;
}

const { videoId } = useParams<UrlParams>();

const [video, setVideo] = useState<Video>();

useEffect(() => {
  axios.get(`${BASE_URL}/videos/${videoId}`)
  .then(response => {
    setVideo(response.data);
  });
}, [videoId]);

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
                url={video?.url}
                width="100%"
              />
            </div>
            <div className="video-description">
              <h1>{video?.titulo}</h1>
              <p>{video?.descricao}</p>
              <p>
                <strong>Categoria:</strong> {video?.categoriaId}
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
