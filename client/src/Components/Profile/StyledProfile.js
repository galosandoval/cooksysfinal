import styled from "styled-components";

export const StyledProfile = styled.div`
  display: flex;
  justify-content: center;
  background: #f8f8f8;
  .profile-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 55%;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
    background: white;
    padding: 3% 0;
    margin: 5% 0;
    border-radius: 4px;
  }
  .pair {
    display: flex;
    justify-content: space-between;
  }
  .title {
    text-align: center;
    border-bottom: 1.4px solid black;
  }
  .title h4 {
  }
  .company,
  .user,
  .projects,
  .team {
    width: 80%;
    padding: 10px 0;
  }
  p {
    padding: 5px 0;
  }
  .hide {
    display: none;
  }
`;
