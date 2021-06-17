// state = {
//     items: [],
//     errorMessage: ''
//   }

// componentDidMount() {
//     axios.get('http://localhost:3333/items')
//       .then(response => this.setState({items: response.data}))
//       .catch(err => { console.log(err) })
//   }

// componentDidMount() {
//     axios.get('http://localhost:3333/items')
//       .then(response => this.setState({items: response.data}))
//       .catch(err => { 
//         this.setState({errorMessage: err.message});
//       })
//   }

// { this.state.errorMessage &&
//     <h3 className="error"> { this.state.errorMessage } </h3> }