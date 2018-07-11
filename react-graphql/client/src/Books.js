import React from 'react';
import { Query } from 'react-apollo';
import gql from 'graphql-tag';

const Courses = () => (
  <Query
    query={gql`
      {
        books {
          title
        }
      }
    `}
  >
    {({ loading, error, data }) => {
      if (loading) return <p>Loading...</p>;
      if (error) return <p>Error :(</p>;

      return data.books.map(({ title }) => (
        <div key={title}>
          <h3>{title}</h3>
        </div>
      ));
    }}
  </Query>
);

export default Courses;
