import { useDispatch } from "react-redux";
import { Link } from "react-router-dom";
import { removeUser } from "../../store/loginReducer";
import { NavbarStyles } from "./StyledNavbar";
import GR from '../Navbar/GR.png'

const Navbar = () => {
  const dispatch = useDispatch();
  const logout = () => {
    dispatch(removeUser());
  };
  return (
      <NavbarStyles>
        <img src={GR} alt="Logo" width='40' height='30'/>
        
        <Link to="/users">Users</Link>
        <Link to="/projects">Projects</Link>
        <Link to="/company">Teams</Link>
        <Link to="/profile">Profile</Link>
        <Link onClick={logout} to="/">
          Logout
        </Link>
      </NavbarStyles>
  );
};

export default Navbar;
