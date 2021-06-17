import React from "react";

import { useState, useEffect } from "react";
import {  useHistory } from "react-router-dom";
import {
  InspectP,
  Styledmain,
  Form,
  Input,
  Button,
  Select,
} from "./StyledCreateProject";
import dummyData from "../../DummyData.json";
import axios from "axios";
import store from "../../index";

const CreateProject = () => {
  const history = useHistory();
  const user = store.getState();

  const initialFormError = {
    isError: false,
    message: "",
    field: "",
  };
  const [form, updateForm] = useState({
    name: {
      value: "",
      placeholder: "project name",
      type: "text",
    },

    description: {
      value: "",
      placeholder: "project description",
      type: "text",
    },
  });

  const [formError, updateFormError] = useState(initialFormError);
  const resetError = () => updateFormError(initialFormError);

  const formIsValid = () => {
    if (!form.name.value || !form.description.value) {
      updateFormError({
        ...formError,
        isError: true,
        message: "All fields are required",
      });
      return false;
    }
    return true;
  };

  const handleFormSubmitt = (e) => {
    if (formIsValid()) {
      e.preventDefault();
      console.log(form.name);
      console.log(form.description);
      console.log(selectTeam.team);
      let newProject = {
        credentials: {
          userName: user.userName,
          password: user.password,
        },

        project: {
          name: form.name.value,
          description: form.description.value,
          team: { teamName: selectTeam.team },
        },
      };
      console.log(newProject);
     

        axios
          .post("http://localhost:8080/project",newProject )
          .then((res) => {
            localStorage.setItem("currentProject", JSON.stringify(res.data));
            history.push("/createprojectsuccess");
          })
          .catch((err) => console.log(err));
    }
    history.push("/createprojectsuccess");
  };

  const [selectTeam, updateTeam] = useState([]);

 
  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(`http://localhost:8080/team`);

      updateTeam(await result.data);
    };

    fetchData();
  }, [updateTeam]);
  console.log(selectTeam);

  return (
    <InspectP>
      <Styledmain>
        <Form onSubmit={handleFormSubmitt}>
          <h1 style={{ margin: "20px", color: "blue" }}>Create Project</h1>

          {Object.entries(form).map(([key, props]) => (
            <Input
              key={key}
              {...props}
              onChange={(event) => {
                updateForm({
                  ...form,
                  [key]: { ...props, value: event.target.value },
                });
                console.log(event.target.value);
                resetError();
              }}
            />
          ))}

          <Select
            value={selectTeam}
            onChange={(e) => {
              const team = e.target.value;
              console.log(team);
              updateTeam({
                team,
              });
            }}
          >
            <option value="" defaultValue disabled>
              choose a team
            </option>
            {dummyData.data[2].teams.map((team) => (
              <option key={`${team.name}-${team.id}`} name={team.name}>
                {team.name}
              </option>
            ))}
          </Select>

          <Button type="submit" onClick={handleFormSubmitt}>
            Create
          </Button>

          {formError.isError && !formError.field ? (
            <p style={{ color: "red", textSizeAdjust: "25" }}>
              {formError.message}
            </p>
          ) : (
            ""
          )}
        </Form>
      </Styledmain>
    </InspectP>
  );
};

export default CreateProject;
