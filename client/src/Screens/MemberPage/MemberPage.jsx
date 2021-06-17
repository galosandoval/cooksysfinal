import StyledMemberPage from "./StyledMemberPage";
import NavBar from "../../Components/Navbar/Navbar";
import { UserCard } from "../../Components/Card/UserCard";
import { Fragment } from "react";
import { NavLink } from "react-router-dom";
import CreateP from "./StyledMemberPage";
const dummyData = require("../../DummyData.json");

//this equation is supposed to get the user data
//now its hard coded to one user

//TODO: set up the equation to retrieve the data called from the login info
const filterUser = dummyData.data[0].user.filter(
  (u) => u.username === "gmoney"
);

// this euqation determines if the user is a part of a team
const newMemberTag = filterUser[0].group_id === "undefined" ? true : false;

export const MemberPage = () => {
  if (newMemberTag === true) {
    return (
      <div>
        <h2>MemberPage</h2>
        <p>You are still not on a team.</p>
        <p>Your company has been notified.</p>
      </div>
    );
  }

  const getProjectsArray = () => {
    let projectsArray = [];
    filterUser.forEach((u) => {
      u.projects.forEach((project) => {
        projectsArray.push(project);
      });
    });
    return projectsArray;
  };

  return (
    <Fragment>
      <NavBar />
      <StyledMemberPage className="member-page">
        <div className="member-page-container">
          <div className="title">
            <h2>Member Page</h2>
          </div>
          <div className="card-container">
            {getProjectsArray().map((project) => (
              <UserCard className="card" name={project} key={`${project}`} />
            ))}
          </div>
          <NavLink to="./createproject">
            <CreateP type="submit">Create Project</CreateP>
          </NavLink>
        </div>
      </StyledMemberPage>
    </Fragment>
  );
};
