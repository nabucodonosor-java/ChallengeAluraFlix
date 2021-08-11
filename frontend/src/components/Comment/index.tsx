import { Comment } from 'types/comment';
import './styles.css';

type Props = {
    comment: Comment;
}

const UserComment = ( { comment } : Props ) => {
    return (
        <div className="comment-container base-card">
            <span>{comment.userName}</span>
            <p>{comment.text}</p>
        </div> 
    );
}

export default UserComment;