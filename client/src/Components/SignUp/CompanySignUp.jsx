import React from "react";
import axios from "axios";

import { useState } from "react";
import { InspectP, Styledmain, Form, Input, Button } from "./StyledSignUp";
import { useHistory } from "react-router";

const initialFormState = {
  companyName: {
    value: "",
    placeholder: "Company Name",
    type: "text",
  },

  companyDescription: {
    value: "",
    placeholder: "Company Description",
    type: "text",
  },

  userName: {
    value: "",
    placeholder: "Username",
    type: "text",
    name: "username",
  },

  password: {
    value: "",
    placeholder: "Password",
    type: "password",
  },
};

const CompanySignUp = () => {
  const [form, updateForm] = useState(initialFormState);
  const initialFormError = {
    isError: false,
    message: "",
    field: "",
  };

  const history = useHistory();
  const [formError, updateFormError] = useState(initialFormError);
  const resetError = () => updateFormError(initialFormError);

  const formIsValid = () => {
    if (
      !form.companyName.value ||
      !form.companyDescription.value ||
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

  const handleFormSubmitt = (e) => {
    if(formIsValid()){
    const postData = {
      seedCompany: {
        companyName: form.companyName.value,
        companyDescription: form.companyDescription.value,
      },
      seedUser: {
        userName: form.userName.value,
        password: form.password.value,
      },
    };

    axios
      .post("http://localhost:8080/company", postData)
      .then((res) => {
        history.push("/");
      })
      .catch((err) => console.log(err));
  };
}

  return (
    <InspectP>
      <Styledmain>
        <Form onSubmit={handleFormSubmitt}>
          <h1 style={{ margin: "20px", color: "blue" }}>Company</h1>

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

export default CompanySignUp;
