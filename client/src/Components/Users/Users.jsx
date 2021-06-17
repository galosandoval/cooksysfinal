import { StyledUsers } from "./StyledUsers";
import Navbar from "../Navbar/Navbar";
import { Fragment, useCallback, useEffect, useState } from "react";
import axios from "axios";
import { UserCard } from "../Card/UserCard";
import store from "../../index";

export const Users = () => {
  const [usersWithoutRole, setUsersWithoutRole] = useState([]);
  const [allUsers, setAllUsers] = useState([]);
  const [teamlessCount, setTeamlessCount] = useState(0);

  const companyName = store.getState().userCompany?.companyName;

  const getUsersFromCompany = useCallback(() => {
    axios
      .get(`http://localhost:8080/company/${companyName}`)
      .then((res) => {
        setUsersWithoutRole(res.data.users.filter((user) => !user.isDeleted));
        setTeamlessCount(
          res.data.users.filter(
            (user) =>
              user.associatedTeam === null &&
              !user.isDeleted &&
              user.firstName !== null
          ).length
        );
      })
      .catch((err) => console.log(err));
  }, [companyName]);

  const getUsersWithRole = useCallback(() => {
    axios
      .get("http://localhost:8080/user")
      .then((res) => {
        setAllUsers(
          res.data.filter(
            (user) =>
              !user.isDeleted &&
              user.associatedTeam !== null &&
              user.userCompany.companyName === companyName
          )
        );
      })
      .catch((err) => console.log(err));
  }, [companyName]);

  const allUsersHaveTeams = (
    <StyledUsers>
      <div className="title">
        <h2>Users</h2>
        <p>All users are a on a team</p>
      </div>
      <div className="users-container">
        <div className="card-container">
          {allUsers.map((user) => (
            <UserCard
              key={`${user?.userName}-${user?.lastName}`}
              name={`${user?.firstName} ${user?.lastName}`}
              team={user?.associatedTeam?.teamName}
            />
          ))}
        </div>
      </div>
    </StyledUsers>
  );

  const addTeamToUser = (
    <StyledUsers>
      <div className="title">
        <h2>
          Users
          {teamlessCount > 0 ? (
            <sup className="notification">{teamlessCount}</sup>
          ) : (
            ""
          )}
        </h2>
        <p>Assign Users to a team</p>
      </div>
      <div className="users-container">
        <div className="left">
          <div className="card-container">
            {usersWithoutRole.map((user) => (
              <UserCard
                key={`${user?.userName}-${user?.lastName}`}
                name={`${user?.firstName} ${user?.lastName}`}
                team={user?.associatedTeam?.teamName}
                userName={user?.userName}
                getUsersFromCompany={getUsersFromCompany}
                getUsersWithRole={getUsersWithRole}
              />
            ))}
          </div>
        </div>
        <div className="right">
          <div className="card-container">
            {allUsers.map((user) => (
              <UserCard
                key={`${user?.userName}-${user?.lastName}`}
                name={`${user?.firstName} ${user?.lastName}`}
                team={user?.associatedTeam?.teamName}
                userName={user?.userName}
              />
            ))}
          </div>
        </div>
      </div>
    </StyledUsers>
  );

  useEffect(() => {
    getUsersFromCompany();
    getUsersWithRole();
  }, [getUsersFromCompany, getUsersWithRole]);

  return (
    <Fragment>
      <Navbar />
      {usersWithoutRole.length === 0 ? allUsersHaveTeams : addTeamToUser}
    </Fragment>
  );
};
