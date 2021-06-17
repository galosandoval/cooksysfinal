// Action

const SAVE_USER = "SAVE_USER";
const REMOVE_USER = "REMOVE_USER";

const initialUserState = {
  firstName: "",
  isDeleted: false,
  lastName: "",
  associatedTeam: null,
  newUser: true,
  projects: [],
  userCompany: {},
  userName: "",
  userRole: {},
  password: "",
};

export const saveUser = (
  firstName,
  lastName,
  userName,
  userCompany,
  userRole,
  projects,
  associatedTeam,
  isDeleted,
  newUser,
  password
) => ({
  type: SAVE_USER,
  firstName,
  lastName,
  userName,
  userCompany,
  userRole,
  projects,
  associatedTeam,
  isDeleted,
  newUser,
  password,
});

export const removeUser = () => ({
  type: REMOVE_USER,
});

// Reducer

export const loginReducer = (state = initialUserState, action) => {
  switch (action.type) {
    case SAVE_USER:
      return {
        ...state,
        firstName: action.firstName,
        lastName: action.lastName,
        userName: action.userName,
        userCompany: action.userCompany,
        userRole: action.userRole,
        projects: action.projects,
        associatedTeam: action.associatedTeam,
        isDeleted: action.isDeleted,
        newUser: action.newUser,
        password: action.password,
      };
    case REMOVE_USER:
      return { initialUserState };
    default:
      return state;
  }
};
