import Pagination from 'components/Pagination';
import VideoCard from 'components/VideoCard';
import { Video } from 'types/video';
import './styles.css';

const VideoList = () => {

  const video: Video = {
    "id": 1,
    "categoriaId": 1,
    "titulo": "A Guerra Franco-Prussiana",
    "descricao": "A Guerra Franco-Prussiana e a Unificação da Alemanha",
    "url": "https://www.youtube.com/watch?v=QLuYGxJzNlE&t=242s"
};

  return (
    <div className="list-container">
      <div className="row">
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <VideoCard video={video} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <VideoCard video={video} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <VideoCard video={video} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <VideoCard video={video} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <VideoCard video={video} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <VideoCard video={video} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <VideoCard video={video} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <VideoCard video={video} />
        </div>
      </div>
      <div className="row">
        <Pagination />
      </div>
    </div>
  );
};

export default VideoList;
