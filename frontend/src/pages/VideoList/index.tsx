import Navbar from 'components/Navbar';
import VideoCard from 'components/VideoCard';
import './styles.css';

const VideoList = () => { 
  return (
    <>
    <Navbar />
    <div className="container my-4">
      <VideoCard />
    </div>
    </>
  );
};

export default VideoList;
