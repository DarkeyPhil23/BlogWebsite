import React from 'react'
import { Outlet } from 'react-router-dom'
import NavBarComponent from '../components/NavBarComponent'
const MainLayout = () => {
        {
            /* 
                Load data from the server
            */
        }
    {
      /*
        TODO: make api call and load it to our userStatus to pass it as a prop to our NavBar Component
        TODO: 
      */
    }
    
    var userStatus = 'default';


  return (
    <>
      
    <NavBarComponent userStatus = {userStatus}/>
    <Outlet
    />
    

    </>
  )
}

export default MainLayout