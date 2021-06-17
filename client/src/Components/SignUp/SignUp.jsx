import React from "react";
import axios from "axios";

import { useHistory } from "react-router";
import { useState, useEffect } from "react";
import {
  InspectP,
  Styledmain,
  Form,
  Input,
  Button,
  Select,
} from "./StyledSignUp";

const SignUp = () => {
  const [selectCompanyName, updateCompanyName] = useState("");
  const [companies, setCompanies] = useState([]);
  const history = useHistory();

  const [form, updateForm] = useState({
    firstName: {
      value: "",
      placeholder: "First Name",
      type: "text",
    },

    lastName: {
      value: "",
      placeholder: "Last Name",
      type: "text",
    },

    userName: {
      value: "",
      placeholder: "Username",
      type: "text",
      name: "text",
    },

    password: {
      value: "",
      placeholder: "Password",
      type: "password",
    },
  });

  const initialFormError = {
    isError: false,
    message: "",
    field: "",
  };

  const [formError, updateFormError] = useState(initialFormError);
  const resetError = () => updateFormError(initialFormError);

  const formIsValid = () => {
    if (
      !form.firstName.value ||
      !form.lastName.value ||
      !form.userName.value ||
      !form.password.value
    ) {
      updateFormError({
        ...formError,
        isError: true,
        message: "All fields are required",
      });
      return false;
    }
    return true;
  };

  const getCompanies = () => {
    axios.get("http://localhost:8080/company").then((res) => {
      const data = res.data;

      setCompanies(data);
    });
  };

  const assignCompany = (e) => {
    updateCompanyName(e.target.value);  
  };

  const handleFormSubmitt = (e) => {
    e.preventDefault();
   if(formIsValid()){
    const postInfo = {
      createUser: {
        userName: form.userName.value,
        firstName: form.firstName.value,
        lastName: form.lastName.value,
        password: form.password.value,
      },
      companyName: selectCompanyName,
    };
    const patchInfo = {
      credentials: {
        userName: "JP Lobster",
        password: "Money",
      },
      roleName: "Member",
    };

    axios
      .post("http://localhost:8080/user", postInfo)
      .then((res) =>
        axios
          .patch(
            `http://localhost:8080/user/${form.userName.value}/role`,
            patchInfo
          )
          .then((res) => console.log(res))
      )
      .then((res) => history.push("/"))
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
  };

}
  useEffect(() => {
    getCompanies();
  }, []);
    
  return (
    <InspectP>
      <Styledmain>
        <Form onSubmit={handleFormSubmitt}>
          <h1 style={{ margin: "20px", color: "blue" }}>Member</h1>

          {Object.entries(form).map(([key, props]) => (
            <Input
              key={key}
              {...props}
              onChange={(event) => {
                updateForm({
                  ...form,
                  [key]: { ...props, value: event.target.value },
                });
                resetError();
              }}
            />
          ))}

          <Select onChange={assignCompany}>
            <option>Select a company</option>
            {companies.map((company) => (
              <option key={`${company.companyName}`}>
                {company.companyName}
              </option>
            ))}
          </Select>

          <Button type="submit" onClick={handleFormSubmitt}>
            Sign Up
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

export default SignUp;
