import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route
} from "react-router-dom";

import App from './App.jsx'
import './index.css'
import ErrorPage from './pages/ErrorPage.jsx';
import IndexPage from './pages/IndexPage.jsx';
import MainLayout from './layouts/MainLayout.jsx';
import TagsPage from './pages/TagsPage.jsx';
import CategoriesPage from './pages/CategoriesPage.jsx';
import ProfileComponent from './components/NavBarComponents/ProfileComponent.jsx';

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" errorElement= {<ErrorPage/>} element={<MainLayout/>  }>
      <Route path="/" element={ <IndexPage/>}/>
      <Route path="/categories" element={ <CategoriesPage/>}/>
      <Route path="/tags" element={<TagsPage/>}/>
      <Route path="/Profile/:id" element={<ProfileComponent/>}/>
    </Route>
  )
);
createRoot(document.getElementById('root')).render(
  <StrictMode>
       <RouterProvider router={router} />
  </StrictMode>,
)
