import { StyledCard } from "./StyledCard";
import axios from "axios";
import { useState } from "react";
import { store } from "../../index";
import $ from "jquery";

const TeamCard = (props) => {
  const initialFormState = {
    credentials: {
      userName: store.getState().userName,
      password: store.getState().password,
    },
    team: {
      teamName: props.name,
      teamDescription: props.teamDescription,
    },
  };
  const [editFormValues, setEditFormValues] = useState(initialFormState);
  const [showCancel, setShowCancel] = useState(false);

  const hideElements = () => {
    $(`.${props.index}`).toggleClass("hide");
    if (!showCancel) {
      setShowCancel(true);
    } else {
      setShowCancel(false);
    }
  };

  const handleClick = (event) => {
    hideElements();
  };

  const handleChange = (event) => {
    setEditFormValues({
      ...editFormValues,
      team: { ...editFormValues.team, [event.target.name]: event.target.value },
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    axios
      .patch(`http://localhost:8080/team/update/${props.name}`, editFormValues)
      .then((res) => props.getCompanies())
      .catch((err) => console.log(err));
    
    hideElements();
  };

  const deleteTeam = () => {
    const deleteBody = props.credentials;
    axios
      .delete(`http://localhost:8080/team/delete/${props.name}`, {
        data: {
          userName: deleteBody.userName,
          password: deleteBody.password,
        },
      })
      .then((res) => props.getCompanies())
      .catch((err) => console.log(err));
  };

  return (
    <StyledCard>
      <div className="team-card">
        <h3>{props.name}</h3>
        <div className="team-container">
          <div className="left">
            <p>Description</p>
            <p>Team Members</p>
          </div>
          <div className="right">
            <p>{props.teamDescription}</p>
            {props.members.map((member) => (
              <p key={`${member.firstName}-${member.lastName}`}>
                {member.firstName} {member.lastName}
              </p>
            ))}
          </div>
        </div>
      </div>
      <div className="buttons">
        {showCancel ? (
          <button onClick={handleClick}>Cancel</button>
        ) : (
          <button onClick={handleClick}>Edit</button>
        )}
        <form onSubmit={handleSubmit} className="button">
          <button type="submit" className={`${props.index} hide`}>
            Save
          </button>
        </form>
        <div className="button">
          <input
            placeholder="Update Team Name"
            className={`${props.index} hide`}
            type="text"
            onChange={handleChange}
            value={editFormValues.team.teamName}
            name="teamName"
          />
          <input
            placeholder="Update Team Description"
            className={`${props.index} hide`}
            type="text"
            onChange={handleChange}
            value={editFormValues.team.teamDescription}
            name="teamDescription"
          />
        </div>
        <div className={`${props.index}`}>
          <button onClick={deleteTeam}>Delete</button>
        </div>
      </div>
    </StyledCard>
  );
};

export default TeamCard;
