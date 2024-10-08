import React from 'react'
import { Link } from 'react-router-dom'
import ProfileImgComp from './NavBarComponents/ProfileImgComp'

const NavBarComponent = ({userStatus}) => {
  return (
    <div>
        <ul className='flex justify-center h-12 w-full ml-auto mr-auto '>
            <div className="flex w-24 bg-red-400 items-center justify-center ">
            <li className='flex-none '><Link to = {"/"}> Home</Link></li>
            </div>
            <div className="flex w-1/2 items-center bg-amber-300 mr-40 ">
                <li className='flex-initial mx-6'><Link to = {'/categories'}>Categories</Link></li> 
                <li className='flex-initial mx-6'><Link to = {'/tags'}>Tags</Link></li>

                <li className='flex ml-auto justify-center items-center mx-6'>  {/* 
                        Based on state Of user authentication  
                        Will be Default if no user.
                        Will be image from the user image[] byte                     
                    */
                      <ProfileImgComp  userPic={ userStatus}  />
                    }
                    
                    <Link to={`/Profile/${userStatus}`}>
                    
                        Blah Blah
                </Link></li>
            </div>
        </ul>


    </div>
  )
}

export default NavBarComponent