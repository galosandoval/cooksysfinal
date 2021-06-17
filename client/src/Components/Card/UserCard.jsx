import axios from "axios";
import { Fragment, useCallback, useEffect, useState } from "react";
import Button from "../Button/Button";
import { StyledCard } from "./StyledCard";
import store from "../../index";
import { credentials } from "../../utils/Credentials";

export const UserCard = (props) => {
  const [teams, setTeams] = useState("");
  const [teamName, setTeamName] = useState("");
  const patchBody = {
    credentials,
    teamName,
  };

  const filterTeams = (array) =>
    array.filter(
      (team) =>
        team.parentCompany.companyName ===
        store.getState().userCompany.companyName
    );

  const getTeams = useCallback(() => {
    axios
      .get("http://localhost:8080/team")
      .then((res) => {
        console.log(res.data);
        setTeams(filterTeams(res.data));
      })
      .catch((err) => console.log(err));
  }, []);

  const handleClick = (e) => {
    e.preventDefault();
    axios
      .patch(`http://localhost:8080/user/${props.userName}/team`, patchBody)
      .then((res) => {
        props.getUsersFromCompany();
        props.getUsersWithRole();
        setTeamName("");
      })
      .catch((err) => console.log(err));
  };

  useEffect(() => {
    getTeams();
  }, [getTeams]);

  const teamForm = (
    <Fragment>
      <form onSubmit={handleClick}>
        <select onChange={(e) => setTeamName(e.target.value)}>
          <option>Assign a team...</option>
          {teams && teams.map((team) => (
            <option key={`${team.teamName}`}>{team.teamName}</option>
          ))}
        </select>
        <button name={`${props.userName}`}>+</button>
      </form>
    </Fragment>
  );
  return (
    <StyledCard>
      <h3>{props.name.includes("null") ? null : props.name}</h3>
      {props.name.includes("null") ? (
        <h3>{props.userName}</h3>
      ) : props.team !== undefined ||
        store.getState()?.userRole.roleTitle === "Member" ? (
        <p>{props.team}</p>
      ) : (
        teamForm
      )}
      <div className="buttons">
        <div className="button">
          <Button name="Edit"></Button>
        </div>
      </div>
    </StyledCard>
  );
};
