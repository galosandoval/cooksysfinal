
import { StyledButton } from './StyledButton';

const Button = props => {
return(
    <div className = "button">
        <StyledButton>
            {props.name}
        </StyledButton>
    </div>
)
}



export default Button
