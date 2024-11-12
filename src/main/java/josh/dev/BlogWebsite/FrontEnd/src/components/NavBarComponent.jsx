import React from 'react'
import { Link } from 'react-router-dom'
import ProfileImgComp from './NavBarComponents/ProfileImgComp'
const NavBarComponent = ({userStatus}) => {
  return (
    <>
  <ul className="flex justify-center h-16 w-full mx-auto bg-gray-100 text-gray-800 shadow-lg">

  
  {/* Navigation Items */}
  <div className="flex w-1/2 items-center bg-white border border-gray-300 rounded-lg mx-4 space-x-4">
  <li className=" flex  grow  items-center justify-center px-8 py-3 hover:bg-indigo-500 hover:text-white rounded-lg transition-all duration-200">
    <Link to = {"home"} className=''> Home</Link></li>
    {/* Categories */}
    <li className="flex  grow items-center justify-center px-8 py-3 hover:bg-indigo-500 hover:text-white rounded-lg transition-all duration-200">
      <Link to="categories">Categories</Link>
    </li>

    {/* Tags */}
    <li className="flex  grow items-center justify-center px-8 py-3 hover:bg-indigo-500 hover:text-white rounded-lg transition-all duration-200">
      <Link to="tags">Tags</Link>
    </li>

    {/* Profile */}
    <li className="flex grow-0  items-center justify-center ml-auto px-8 py-3 hover:bg-indigo-500 hover:text-white rounded-lg transition-all duration-200">
      {/* Profile Image Component */}
      <ProfileImgComp userPic={userStatus} />
      
      {/* Profile Link */}
      <Link to={`Profile/${userStatus}`} className="ml-2">
        Blah Blah
      </Link>
    </li>
  </div>
</ul>



    </>
  )
}

export default NavBarComponent