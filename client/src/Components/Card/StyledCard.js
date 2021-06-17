import styled from "styled-components";

export const StyledCard = styled.div`
  background: white;
  padding: 15px;
  color: black;
  width: 45%;
  height: 300px;
  margin: 2.5%;
  transition: all 0.4s ease;
  border-radius: 2px;
  text-align: center;
  background-color: white;
  border-radius: 2px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  display: flex;
  flex-direction: column;
  align-items: center;
  &:hover {
    transform: size(1.1);
  }
  .buttons {
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
    height: 90%;
    width: 100%;
    padding: 0 25px;
  }
  .team-card {
    display: flex;
    flex-direction: column;
    width: 100%;
    padding: 15px 0;
  }
  .team-container {
    display: flex;
    justify-content: space-between;
  }
  .left, .right {
    width: 50%;
  }
  .left p {
    font-weight: 600;
    padding: 5px 0;
  }
  .right p {
    padding: 5px 0;
  }
  .hide {
    display: none;
  }
  h3 {
    padding-bottom: 10px;
  }
`;
