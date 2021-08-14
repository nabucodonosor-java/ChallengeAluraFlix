import React from 'react';
import { ReactComponent as ArrowIcon } from 'assets/images/arrow.svg';
import './styles.css';

type Props = {
  text: string;
};

const ButtonIcon = ({ text }: Props) => (
  <div className="btn-container">
    <div className="btn-text-area">
      <button className="btn-text">
          <h6>{text}</h6>
      </button>
    </div>
    <div className="btn-arrow">
    <ArrowIcon />
    </div>
  </div>
);

export default ButtonIcon;
