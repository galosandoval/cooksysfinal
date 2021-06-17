import {NavLink} from "react-router-dom";
import Button from '../Button/Button'

const createprojectsuccess = () => {
    return(
    <div>
        <p>Project successfully created!
        </p>
        <p>press button to return to member page</p>
        <NavLink to='./member'>
            <Button type="submit"  >To Member</Button>
        </NavLink>
    </div>
    )}
export default createprojectsuccess