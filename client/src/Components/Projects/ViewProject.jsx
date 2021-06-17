import React, { useState, useEffect } from "react";
import { InspectP, Styledmain } from "../CreateProject/StyledCreateProject";
import { Form } from "../SignUp/StyledSignUp";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
export default function ViewProject(props) {
  const [data, setData] = useState({});
  const [values, setValues] = useState({
    name: "",
    description: "",
    company: "",
    userName:"",
    team: { teamName: "", teamMembers: [] },
  });
  console.log(props.location.state);

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(
        `http://localhost:8080/project/${props.location.state.name}`
      );

      setData(await result.data);

      //   console.log(result.data);
      //   setProjectName(data.name);
      //   // inputEl.current.value = data.name
      //   setProjectDesc(data.description);
    };

    fetchData();
  }, [setData]);
  console.log(data);
  useEffect(() => {
    // if (data.team == null || team.team === undefined) {
    //   setValues((state) => ({ ...state, projectTeam: "Non-Existent" }));
    // } else {
    //   setValues((state) => ({ ...state, projectTeam: data.team.teamName }));
    // }
    
    if (data.team) {
      setValues((state) => ({
        ...state,
        team: { teamName: data.team.teamName },
      }));
    } else {
      setValues((state) => ({ ...state, team: { teamName: "" } }));
    }
  }, [data.team]);
  useEffect(() => {
    setValues((state) => ({ ...state, name: data.name }));
  }, [data.name]);
  useEffect(() => {
    setValues((state) => ({ ...state, description: data.description }));
  }, [data.description]);

  useEffect(() => {
    setValues((state) => ({ ...state, company: data.company }));
  }, [data.company]);

//   useEffect(() => {
//     setValues((state) => ({
//       ...state,
//       userName: data.user.userName
//     }));
//   }, [data.user.userName]);

//   useEffect(() => {
//     setValues((state) => ({ ...state, team:{teamName: data.team.teamName} }));
//   }, [data.description]);

//   useEffect(() => {
//     setValues((state) => ({ ...state, description: data.description }));
//   }, [data.description]);

  return (
    <div>
        <Navbar/>
      <InspectP>
        <Styledmain>
          <Form>
            <p>Name:{values.name}</p>
            <p>Description:{values.description}</p>
            <p>Company:{values.company}</p>
            {/* <p>Creator: {data.user.userName}</p> */}
            <p>Team: {values.team.teamName}</p>
            {/* {data.team.teamMembers.map()} */}
          </Form>
        </Styledmain>
      </InspectP>
    </div>
  );
}
