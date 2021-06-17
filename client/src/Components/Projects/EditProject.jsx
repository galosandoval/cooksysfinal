import React, { useState, useEffect, useRef } from "react";
import axios from "axios";
import {
  Form,
  InspectP,
  Styledmain,
  Input,
  Button,
  Select,
} from "../CreateProject/StyledCreateProject";
import { EditProjectInput } from "./StyledProjects";
import store from "../../index";
import { Redirect } from "react-router";
import { render } from "react-dom";
import Navbar from "../Navbar/Navbar";
export default function EditProject(props) {
  // console.log(this.queryParams)
  console.log(props.location.state.name);
  //  console.log(props.match.params)

  const initialFormError = {
    isError: false,
    message: "",
    field: "",
  };

  const user = store.getState();
  console.log(user.userName);
  console.log(user.password);

  const [data, setData] = useState({});
  const [updated,setUpdated] = useState(false)

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(
        `http://localhost:8080/project/${props.location.state.name}`
      );

      setData( await result.data);
    };

    fetchData();
  }, [setData]);

  const [values, setValues] = useState({
    projectName: "",
    projectDesc: "",
    projectTeam: "",
  });
  const [team, setTeam] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(`http://localhost:8080/team`);

      setTeam(await result.data);
    };

    fetchData();
  }, [setTeam]);
  console.log(team);

  useEffect(() => {
    setValues((state) => ({ ...state, projectName: data.name }));
  }, [data.name]);
  useEffect(() => {
    setValues((state) => ({ ...state, projectDesc: data.description }));
  }, [data.description]);
  useEffect(() => {
    // if (data.team == null || team.team === undefined) {
    //   setValues((state) => ({ ...state, projectTeam: "Non-Existent" }));
    // } else {
    //   setValues((state) => ({ ...state, projectTeam: data.team.teamName }));
    // }
    if(data.team){
      setValues((state) => ({ ...state, projectTeam: data.team.teamName}))
    }
    else{
      setValues((state) => ({ ...state,projectTeam: ""}))
    }
  }, [data.team]);
  // useEffect(() => {
  //   setValues((state) => ({ ...state, projectTeam: data.team.teamName }));
  // },[data.team.teamName]);
  //   console.log(data);
  //   console.log(data.name);

  const [deleted, isDeleted] = useState(false);
  //   setProjectDesc(data.name)
  const handleFormSubmit = (event) => {

    console.log(values)
    event.preventDefault();
    const updatedProject = { 
      credentials:{
      userName: user.userName,
      password: user.password}, 
      project:{
        name: values.projectName,
        description: values.projectDesc,
        team: {teamName:values.projectTeam}
      }
        
     
    }
    axios.patch(`http://localhost:8080/project/${props.location.state.name}`,updatedProject)
    setUpdated(true)

  };
  const handleChange = (event) => {
    // use spread operator
    setValues({
      ...values,
      [event.target.name]: event.target.value,
    });
  };
  const deleteProject = () => {
    let deleteBody = { userName: user.userName, password: user.password };
    isDeleted(true);
    axios
      .delete(`http://localhost:8080/project/${props.location.state.name}`, {
        data: {
          userName: deleteBody.userName,
          password: deleteBody.password,
        },
      })

      .catch((err) => console.log(err));
  };
  console.log(values);

  if (deleted) {
    return <Redirect to="/project" />;
  }
  if(updated){
    return<Redirect to='/project'/>;
  }
  return (
    <div>
      <Navbar />
      <InspectP>
        <Styledmain>
          <Form>
            <h1 style={{ margin: "20px", color: "blue" }}>Edit Project</h1>
            <Input
              value={values.projectName}
              type="text"
              onChange={handleChange}
              placeholder="Project Name"
              name="projectName"
            />
            <Input
              value={values.projectDesc}
              type="text"
              placeholder="Project Description"
              onChange={handleChange}
              name="projectDesc"
            />

            <Select
              value={values.projectTeam}
              onChange={(e) => {
                const team = e.target.value;
                console.log(team);
                setTeam({
                  team,
                });
              }}
              name="team"
            >
              {/* <option value='' defaultValue disabled >choose a team</option>
                        {dummyData.data[2].teams.map((team) => ( */}
              <option value={values.projectTeam}>{values.projectTeam}</option>
              {team.map((team) => {
                return <option value={team.teamName}>{team.teamName}</option>;
              })}
              ))
            </Select>

            <Button type="submit" onClick={handleFormSubmit}>
              Update
            </Button>
            <Button type="submit" onClick={deleteProject}>
              Delete
            </Button>
          </Form>
        </Styledmain>
      </InspectP>
    </div>
  );
}
