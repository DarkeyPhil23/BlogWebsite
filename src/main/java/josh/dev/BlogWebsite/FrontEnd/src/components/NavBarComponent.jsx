import React from 'react'
import { Link } from 'react-router-dom'
import ProfileImgComp from './NavBarComponents/ProfileImgComp'
import HomeComp from './NavBarComponents/HomeComp'
const NavBarComponent = ({userStatus}) => {
  return (
    <div>
        <ul className='flex justify-center h-16 w-full ml-auto mr-auto '>
            <HomeComp/>
            <div className="flex w-1/2 items-center bg-amber-300 mr-40 ">
                <li className='flex-initial px-8 pt-6 pb-4  max-h-fit hover:bg-gray-700 hover:text-red-500'><Link to = {'categories'}>Categories</Link></li> 
                <li className='flex-initial px-8 pt-6 pb-4 my-1 hover:bg-gray-700 hover:text-red-500'><Link to = {'tags'}>Tags</Link></li>
                <li className='flex ml-auto justify-center items-center px-8 pt-5 pb-4 my-1  hover:bg-gray-700 hover:text-red-500'>  {/* 
                        Based on state Of user authentication  
                        Will be Default if no user.
                        Will be image from the user image[] byte                     
                    */
                      <ProfileImgComp  userPic={ userStatus}  />
                    }
                    
                    <Link to={`Profile/${userStatus}`}>
                    
                        Blah Blah
                </Link></li>
            </div>
        </ul>


    </div>
  )
}

export default NavBarComponent