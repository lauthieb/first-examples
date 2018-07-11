import React from 'react';
import ApolloClient from 'apollo-boost';
import { ApolloProvider } from 'react-apollo';
import Books from './Books';
import logo from './logo.svg';
import './App.css';

const client = new ApolloClient({
  uri: 'http://localhost:4000/graphql',
});

class App extends React.Component {
  render() {
    return (
      <ApolloProvider client={client}>
        <div>
          <img src={logo} className="App-logo" alt="logo" />
          <h2>My first React Apollo React Application</h2>
          <Books />
        </div>
      </ApolloProvider>
    );
  }
}

export default App;
