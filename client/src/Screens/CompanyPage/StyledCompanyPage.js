import styled from "styled-components";

export const StyledCompanyPage = styled.div`
  display: flex;
  background: #f8f8f8;
  .company-page-container {
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  .card-container {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
  }
  .hide {
    display: none;
  }
  button {
    border: 2px black solid;
    padding: 10px 10px;
    background: white;
    border-radius: 3px;
    transition: all .3s ease;
    &:hover {
      background: black;
      color: white;
    }
  }

  input {
    padding: 10px;
    margin: 4px;
  }

  .button-container {
    display: flex;
    justify-content: space-evenly
  }
`;
