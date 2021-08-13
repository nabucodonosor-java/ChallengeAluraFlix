import React from 'react';
import LoadingIcon from 'assets/images/loading-icon.svg';

import './styles.css';

const Loader = () => {
  return (
    <div className="loading-loader">
        <h6>Carregando ...</h6>
      <img src={LoadingIcon} alt="nome" />
    </div>
  );
};

export default Loader;
