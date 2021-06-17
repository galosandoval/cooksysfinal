import axios from "axios";
import { store } from "../../index";
import { Fragment, useCallback } from "react";
import TeamCard from "../../Components/Card/TeamCard";
import Navbar from "../../Components/Navbar/Navbar";
import { StyledCompanyPage } from "./StyledCompanyPage";
import { useState, useEffect } from "react";
import $ from "jquery";

const initialTeamForm = {
  teamName: "",
  teamDescription: "",
};

export const CompanyPage = () => {
  const user = store.getState();
  const [teamForm, setTeamForm] = useState(initialTeamForm);
  const [companies, setCompanies] = useState([]);
  const [showSave, setShowSave] = useState(false);

  const credentials = {
    userName: store.getState().userName,
    password: store.getState().password,
  };
  const getCompanies = useCallback(() => {
    axios
      .get(`http://localhost:8080/company/${user.userCompany?.companyName}`)
      .then((res) => {
        const data = res.data;
        const filteredTeams = data.teams.filter((team) => !team.isDeleted);
        setCompanies(filteredTeams);
      });
  }, [user?.userCompany?.companyName]);

  const createTeam = () => {
    const postBody = {
      credentials: credentials,
      team: {
        teamName: teamForm.teamName,
        teamDescription: teamForm.teamDescription,
      },
    };
    axios
      .post("http://localhost:8080/team/create", postBody)
      .then((res) => {
        getCompanies();
      })
      .catch((err) => console.log(err));
  };

  const handleTeamSubmit = (event) => {
    event.preventDefault();
    createTeam();
    setTeamForm(initialTeamForm);
  };

  const hideElements = () => {
    $(`.show`).toggleClass("hide");
    if (!showSave) {
      setShowSave(true);
    } else {
      setShowSave(false);
    }
  };

  const handleClick = (event) => {
    hideElements()

  }

  useEffect(() => {
    getCompanies();
  }, [getCompanies]);
  return (
    <Fragment>
      <Navbar />
      <StyledCompanyPage className="company-page">
        <div className="company-page-container">
          <div className="title">
            <h2>Teams</h2>
          </div>
          <div className="card-container">
            {companies.map((team, index) => (
              <TeamCard
                className="card"
                name={team.teamName}
                key={`${team.teamName}-${index}`}
                members={team.teamMembers}
                teamDescription={team.teamDescription}
                credentials={credentials}
                getCompanies={getCompanies}
                index={index}
              />
            ))}
          </div>
          <div className="form">
            <form onSubmit={handleTeamSubmit}>
              <input
                onChange={(e) =>
                  setTeamForm({ ...teamForm, teamName: e.target.value })
                }
                value={teamForm.teamName}
                placeholder="team name"
                type="text"
                className="show hide"
              />
              <input
                onChange={(e) =>
                  setTeamForm({ ...teamForm, teamDescription: e.target.value })
                }
                value={teamForm.teamDescription}
                placeholder="team description"
                type="text"
                className="show hide"
              />
              {!showSave ? (
                <button onClick={handleClick} type="button" name="+">+</button>
              ) : (
                <div className="button-container">
                  <button onClick={handleClick}>cancel</button>
                  <button type="submit">save</button>
                </div>
              )}
            </form>
          </div>
        </div>
      </StyledCompanyPage>
    </Fragment>
  );
};
