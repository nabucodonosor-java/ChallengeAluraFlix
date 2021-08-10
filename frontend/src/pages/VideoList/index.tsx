import Navbar from 'components/Navbar';
import VideoCard from 'components/VideoCard';
import './styles.css';

const VideoList = () => {
  return (
    <>
      <Navbar />
      <div className="container my-4">
        <div className="row">
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <VideoCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <VideoCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <VideoCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <VideoCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <VideoCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <VideoCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <VideoCard />
          </div>
        </div>
      </div>
    </>
  );
};

export default VideoList;
