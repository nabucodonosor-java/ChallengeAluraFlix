import axios from 'axios';
import Pagination from 'components/Pagination';
import VideoCard from 'components/VideoCard';
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { AxiosParams } from 'types/vendor/axios';
import { SpringPage } from 'types/vendor/spring';
import { Video } from 'types/video';
import { BASE_URL } from 'util/request';
import './styles.css';

const VideoList = () => {
  const [page, setPage] = useState<SpringPage<Video>>();

  useEffect(() => {
    const params: AxiosParams = {
      method: 'GET',
      url: `${BASE_URL}/videos/free`,
      params: {
        page: 0,
        size: 8,
      },
    };

    axios(params).then((response) => {
      setPage(response.data);
    });
  }, []);

  return (
    <div className="list-container">
      <div className="row">
        {page?.content.map((video) => {
          return (
            <div className="col-sm-6 col-lg-4 col-xl-3" key={video.id}>
              <Link to={`/videos/${video.id}`}>
                <VideoCard video={video} />
              </Link>
            </div>
          );
        })}
      </div>
      <div className="row">
        <Pagination />
      </div>
    </div>
  );
};

export default VideoList;
