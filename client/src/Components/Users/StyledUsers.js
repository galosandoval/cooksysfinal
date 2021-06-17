import styled from "styled-components";

export const StyledUsers = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  background: #f8f8f8;
  .notification {
    border: 1px solid red;
    padding: 0 6px;
    border-radius: 100px;
    width: 30px;
    background: red;
    color: white;
  }
  .title h2 {
    text-align: center;
  }
  .users-container {
    width: 100%;
    display: flex;
    align-items: center;
  }
  .card-container {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
  }
  .left {
    border-right: 1px solid black;
    width: 50%;
  }
  .right {
    width: 50%;
  }
`;

export const StyledForm = styled.form`
  display: flex;
  justify-content: flex-end;
`;
