import React from 'react'
import { useParams } from 'react-router-dom'
const ProfileComponent = () => {
const params = useParams();
let userId = params.id;
  return (
    <>
    You are in the Profile page of {userId}
    
    </>
  )
}

export default ProfileComponent