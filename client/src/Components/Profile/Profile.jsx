import { Fragment, useState } from "react";
import store from "../../index";
import Navbar from "../Navbar/Navbar";
import { StyledProfile } from "./StyledProfile";
import $ from "jquery";
import axios from "axios";
import { useDispatch } from "react-redux";
import { saveUser } from "../../store/loginReducer";

const initialCredentialsForm = {
  userName: "",
  password: "",
};

export const Profile = () => {
  const dispatch = useDispatch();
  const user = store.getState();
  const initialFormState = user;

  const [editFormValues, setEditFormValues] = useState(initialFormState);
  const [showCancel, setShowCancel] = useState(false);
  const [credentials, setCredentials] = useState(initialCredentialsForm);

  const handleClick = () => {
    $(".show").toggleClass("hide");
    showCancel ? setShowCancel(false) : setShowCancel(true);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const patchData = {
      credentials: {
        userName: credentials.userName,
        password: credentials.password,
      },
      newData: {
        userName: editFormValues.userName,
        firstName: editFormValues.firstName,
        lastName: editFormValues.lastName,
        password: editFormValues.password,
      },
    };

    axios
      .patch(`http://localhost:8080/user/${user.userName}`, patchData)
      .then((res) => {
        $(".show").toggleClass("hide");
        setShowCancel(false);
        setCredentials(initialCredentialsForm);
        const {
          firstName,
          lastName,
          userName,
          userCompany,
          userRole,
          projects,
          associatedTeam,
          isDeleted,
          newUser,
        } = res.data;
        dispatch(
          saveUser(
            firstName,
            lastName,
            userName,
            userCompany,
            userRole,
            projects,
            associatedTeam,
            isDeleted,
            newUser
          )
        );
        setEditFormValues(user);
      })
      .catch((err) => console.log("error", err));
  };

  const handleChange = (e, state, setState) => {
    const { name, value } = e.target;
    setState({ ...state, [name]: value });
  };

  return (
    <Fragment>
      <Navbar />
      <StyledProfile>
        <form onSubmit={handleSubmit} className="profile-container">
          <h1>Profile</h1>
          <div className="user">
            <div className="pair">
              <p>Username</p>
              <p className="show">{editFormValues.userName}</p>
              <input
                className="hide show"
                name="userName"
                value={editFormValues.userName}
                onChange={(e) =>
                  handleChange(e, editFormValues, setEditFormValues)
                }
                placeholder="new username"
                type="text"
              />
            </div>
            <div className="pair">
              <p>First Name</p>
              <p className="show">{editFormValues.firstName}</p>
              <input
                className="hide show"
                name="firstName"
                value={editFormValues.firstName}
                onChange={(e) =>
                  handleChange(e, editFormValues, setEditFormValues)
                }
                placeholder="new first name"
                type="text"
              />
            </div>
            <div className="pair">
              <p>Last Name</p>
              <p className="show">{editFormValues.lastName}</p>
              <input
                className="hide show"
                name="lastName"
                value={editFormValues.lastName}
                onChange={(e) =>
                  handleChange(e, editFormValues, setEditFormValues)
                }
                placeholder="new last name"
                type="text"
              />
            </div>
            <div className="pair show hide">
              <p>Enter your new password</p>
              <input
                value={editFormValues.password}
                name="password"
                onChange={(e) =>
                  handleChange(e, editFormValues, setEditFormValues)
                }
                placeholder="new password"
                type="text"
              />
            </div>
          </div>

          <p className="show hide">
            Enter your credentials to save your changes
          </p>
          <input
            className="show hide"
            onChange={(e) => handleChange(e, credentials, setCredentials)}
            value={credentials.userName}
            placeholder="username"
            name="userName"
            type="text"
          />
          <input
            className="show hide"
            onChange={(e) => handleChange(e, credentials, setCredentials)}
            value={credentials.password}
            placeholder="password"
            name="password"
            type="text"
          />

          <button type="submit" className="show hide">
            Save
          </button>
          <button type="button" onClick={(e) => handleClick(e)}>
            {showCancel ? "Cancel" : "Edit"}
          </button>
          <div className="company">
            <div className="title">
              <h4>Company</h4>
            </div>
            <div className="pair">
              <p>Name</p>
              <p>{user.userCompany.companyName}</p>
            </div>
            <div className="pair">
              <p>Description</p>
              <p>{user.userCompany.companyDescription}</p>
            </div>
          </div>
          <div className="team">
            <div className="title">
              <h4>Team</h4>
            </div>
            <div className="pair">
              <p>Name</p>
              <p>{user?.associatedTeam?.teamName}</p>
            </div>
            <div className="pair">
              <p>Description</p>
              <p>{user?.associatedTeam?.teamDescription}</p>
            </div>
          </div>
          <div className="projects">
            <h4 className="title">Projects</h4>
            {user.projects.map((project) => (
              <div key={project.name}>
                <div className="pair">
                  <p>Name</p>
                  <p>{project.name}</p>
                </div>
                <div className="pair">
                  <p>Description</p>
                  <p>{project.description}</p>
                </div>
              </div>
            ))}
          </div>
        </form>
      </StyledProfile>
    </Fragment>
  );
};
