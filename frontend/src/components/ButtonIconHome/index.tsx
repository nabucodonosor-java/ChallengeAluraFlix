import IconFilm from 'assets/images/icon-film.gif';
import './styles.css';

type Props = {
    text: string;
}

const ButtonIconHome = ({ text }: Props) => {
  return (
    <button className="btn btn-primary btn-icon">
      <span>
        <h6>{text}</h6>
        <img src={IconFilm} alt="logo" width="7%" />
      </span>
    </button>
  );
};

export default ButtonIconHome;
