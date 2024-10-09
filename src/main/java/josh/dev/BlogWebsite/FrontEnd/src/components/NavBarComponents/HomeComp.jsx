import React from 'react'
import {Link} from 'react-router-dom'

const HomeComp = () => {
  return (

    <div className="flex w-24 bg-red-400 items-center justify-center  ">
    <li className='flex-none '><Link to = {"/"}> Home</Link></li>
    </div>
  )
}

export default HomeComp